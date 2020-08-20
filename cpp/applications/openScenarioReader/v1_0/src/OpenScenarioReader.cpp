/*
 * Copyright 2020 RA Consulting
 *
 * RA Consulting GmbH licenses this file under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#include <sstream>
#include <string>
#include <iostream>
#include <fstream>

#include "ErrorLevel.h"
#include "FileContentMessage.h"
#include "IParserMessageLogger.h"
#include "SimpleMessageLogger.h"
#include "Textmarker.h"
#include "ApiClassImpl.h"
#include "XmlScenarioImportLoaderFactory.h"
#include "ScenarioLoaderException.h"
#include "FileResourceLocator.h"
#include "Version.h"

#undef ERROR


/**
 * Executable for checking an OpenScenario file.
 * <ul>
 * <li> Reading the file
 * <li> Resolving the parameters
 * <li> Resolving the catalog references
 * <li> Checking all type ranges that differ from the ones of the default type (e.g. positiv doubles)
 * </ul>
 *
 */

static NET_ASAM_OPENSCENARIO::ErrorLevel logLevel = NET_ASAM_OPENSCENARIO::ErrorLevel::INFO;

std::shared_ptr<NET_ASAM_OPENSCENARIO::V_1_0::OpenScenarioImpl> ExecuteImportParsing(std::string& filename, std::shared_ptr<NET_ASAM_OPENSCENARIO::SimpleMessageLogger>& messageLogger, std::shared_ptr <NET_ASAM_OPENSCENARIO::IParserMessageLogger> catalogMessageLogger, std::map<std::string, std::string>& injectionParameters)
{
    auto loaderFactory = NET_ASAM_OPENSCENARIO::V_1_0::XmlScenarioImportLoaderFactory(catalogMessageLogger, filename);
    auto loader = loaderFactory.CreateLoader(std::make_shared<NET_ASAM_OPENSCENARIO::FileResourceLocator>());
    return std::static_pointer_cast<NET_ASAM_OPENSCENARIO::V_1_0::OpenScenarioImpl>(loader->Load(messageLogger, injectionParameters)->GetAdapter(typeid(NET_ASAM_OPENSCENARIO::V_1_0::OpenScenarioImpl).name()));
}

std::string GetFilledString(const size_t length, const char charToFill) 
{
    std::stringstream ss;
    ss << std::setfill(charToFill) << std::setw(length) << charToFill;
    return ss.str();
}

std::string Trim(const std::string s) 
{
    return regex_replace(s, std::regex("^\\s+|\\s+$"), "");
}

int main(int argc, char** argv)
{
#if defined(_DEBUG) && defined(WIN32)
    _CrtSetDbgFlag(_CRTDBG_ALLOC_MEM_DF | _CRTDBG_LEAK_CHECK_DF);
#endif

    std::stringstream versionStream;
    versionStream << MAJORVERSION << "." << MINORVERSION << "." << PATCHNUMBER;
    const std::string kVersion = versionStream.str();
    const std::string kHeader = "* ASAM OpenSCENARIO 1.0 Checker (2020) *";
    const std::string kHeaderFillString = GetFilledString(kHeader.length(), '*');

    std::cout << kHeaderFillString << std::endl;
    std::cout << kHeader << std::endl;
    std::cout << kHeaderFillString << std::endl;
    
    bool isCommandLineParsable = false;
    std::string inputFileName = "";
    std::string paramFileName = "";

    if (argc > 1 && std::string(argv[1]) == "-v")
    {
        std::cout << "Program version " << kVersion << std::endl;
        return 0;
    }

    if (argc > 2 && std::string(argv[1]) == "-i")
    {
        inputFileName = argv[2];
        if (argc > 4 && std::string(argv[3]) == "-p")
        {
            paramFileName = argv[4];
        }
        isCommandLineParsable = true;
    }

    if (!isCommandLineParsable)
    {
        std::cout << "OpenScenarioChecker [option] [-p]" << std::endl;
        std::cout << "Options:" << std::endl;
        std::cout << "-i\tinput file name for the file to be validated" << std::endl;
        std::cout << "-v\tprint program version" << std::endl;
        std::cout << "-p\ta file with name/value pairs. One line per name/value pair. tab separated" << std::endl;
        return -1;
    }

    std::map<std::string, std::string> injectedParamters;
    if ( !paramFileName.empty() )
    {
        try 
        {
            std::ifstream paramFile(paramFileName);
            std::string line;

            if (paramFile.bad() || paramFile.fail())
            {
                auto msg = "File " + paramFileName + " not found";
                throw NET_ASAM_OPENSCENARIO::ResourceNotFoundException(msg);
            }

            int counter = 0;

            while (std::getline(paramFile, line))
            {
                counter++;
                if (!std::regex_match(line, std::regex("\\s*$")) && !std::regex_match(line, std::regex("\\s*#.*$")))
                {
                    auto pattern = std::regex("([^\\t]*)\\t([^\\t]*)$");
                    std::smatch match;
                    std::regex_match(line, match, pattern);
                    if ( !match.empty() ) 
                    {
                        auto name = Trim(match[1].str());
                        auto value = Trim(match[2].str());
                        if (!name.empty() && !value.empty()) 
                        {
                            injectedParamters.emplace(std::make_pair(name, value));
                        }
                        else 
                        {
                            std::cout << "Syntax error in parameter file: line " << counter;
                            return -1;
                        }

                    }
                    else 
                    {
                        std::cout << "Syntax error in parameter file: line " << counter;
                        return -1;
                    }
                }
            }
            paramFile.close();
        }
        catch ( NET_ASAM_OPENSCENARIO::ResourceNotFoundException e) 
        {
            std::cout << "paramsfile not found";
            return -1;
        }

        if (!injectedParamters.empty())
        {
            std::cout << "Used Parameters:" <<std::endl;
            for( auto& injectedParamter : injectedParamters )
            {
                std::cout << "\t" + injectedParamter.first + "\t" + injectedParamter.second <<std::endl;
            }
        }
    }

    std::ifstream inputFile(inputFileName);

    if (inputFile.bad() || inputFile.fail())
    {
        std::cout << "Scenario file not found '" + inputFileName + "'";
        return -1;
    }

    inputFile.close();

    std::cout << "Checking '" << inputFileName << "'" << std::endl;

    auto catalogMessageLogger = std::make_shared<NET_ASAM_OPENSCENARIO::SimpleMessageLogger>(logLevel);
    auto messageLogger = std::make_shared<NET_ASAM_OPENSCENARIO::SimpleMessageLogger>(logLevel);

    try
    {
        ExecuteImportParsing(inputFileName, messageLogger, catalogMessageLogger, injectedParamters);

        for (auto&& message : messageLogger->GetMessagesFilteredByWorseOrEqualToErrorLevel(logLevel)) 
        {
            auto textmarker = message.GetTextmarker();
            std::cout << NET_ASAM_OPENSCENARIO::ErrorLevelString::ToString(message.GetErrorLevel()) << ": " << message.GetMsg() << " ("
                << textmarker.GetLine() << "," << textmarker.GetColumn() << ")" << std::endl;
        }

        auto warningMessages = messageLogger->GetMessagesFilteredByErrorLevel(NET_ASAM_OPENSCENARIO::ErrorLevel::WARNING);

        if (messageLogger->GetMessagesFilteredByWorseOrEqualToErrorLevel(NET_ASAM_OPENSCENARIO::ErrorLevel::ERROR).empty()) 
        {
           std::cout << "Validation succeeded with 0 errors and " << warningMessages.size() << " warnings." << std::endl;
        }
        else 
        {
            auto errorMessages = messageLogger->GetMessagesFilteredByErrorLevel(NET_ASAM_OPENSCENARIO::ErrorLevel::ERROR);
            std::cout << "Validation failed with " << errorMessages.size() << " errors and " << warningMessages.size() << " warnings." << std::endl;
        }

        auto catalogMessages = catalogMessageLogger->GetMessagesFilteredByWorseOrEqualToErrorLevel(logLevel);
        if (!catalogMessages.empty()) 
        {
            std::cout << "Info from catalog referencing"<< std::endl;
            std::cout << "============================="<< std::endl;
            for (auto&& message : catalogMessages) 
            {
                auto textmarker = message.GetTextmarker();
                std::cout << NET_ASAM_OPENSCENARIO::ErrorLevelString::ToString(message.GetErrorLevel()) << ": (File:" << textmarker.GetFilename()
                        << ") " << message.GetMsg() << " (" << textmarker.GetLine() << "," << textmarker.GetColumn() << ")" << std::endl;
            }
        }
    }
    catch (NET_ASAM_OPENSCENARIO::ScenarioLoaderException& e)
    {
        std::cout << e.what() << std::endl;
        return -1;
    }

    return 0;
}
