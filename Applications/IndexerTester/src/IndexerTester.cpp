#include <iostream>
#include "MemLeakDetection.h"
#include "PositionIndex.h"
#include "XMLLexer.h"
#include "../../../OpenScenarioLib/src/loader/ResourceNotFoundException.h"
#include "XMLParser.h"

void Dump(RAC_XML_INDEXER::PositionIndex& positionIndex, int& index)
{
    const auto kElementNode = positionIndex.GetElementNode(index);
    std::cout << index << ": " << "(" << kElementNode->GetStartPosition().GetLine() << ", ";
    std::cout << kElementNode->GetStartPosition().GetColumn() << ") - (" << kElementNode->GetEndPosition().GetLine();
    std::cout << ", " << kElementNode->GetEndPosition().GetColumn() << ")" << std::endl;
}

void TestBooks()
{
    try 
    {
        std::string filePath = "../../../../../Applications/OpenScenarioReader/res/indexer/books.xml";
        std::ifstream infile(filePath, std::ios::binary);
        if (infile.bad() || infile.fail())
        {
            auto msg = "File " + filePath + " not found";
            throw RAC_OPENSCENARIO::ResourceNotFoundException(msg);
        }

        // read data as a block:
        infile.seekg(0, infile.end);
        const auto kLength = static_cast<unsigned int>(infile.tellg());
        infile.seekg(0, infile.beg);
        char * buffer = new char[kLength];
        infile.read(buffer, kLength);
        std::string fileData;
        fileData.assign(buffer, kLength);
        delete[] buffer;
        infile.close();

        antlr4::ANTLRInputStream input(fileData);
        XMLLexer lexer(&input);
        antlr4::CommonTokenStream tokens(&lexer);
        XMLParser parser(&tokens);
        parser.document();

        auto positionIndex = parser.GetPositionIndex();
        for (int i = 0; i < positionIndex.GetSize(); i++)
        {
            Dump(positionIndex, i);
        }

    }
    catch ( RAC_OPENSCENARIO::ResourceNotFoundException& e) 
    {
        std::cout << e.what();
    }
}

int main(int argc, char** argv)
{
#if defined(_DEBUG) && defined(WIN32)
    _CrtSetDbgFlag(_CRTDBG_ALLOC_MEM_DF | _CRTDBG_LEAK_CHECK_DF);
#endif

    TestBooks();

}
