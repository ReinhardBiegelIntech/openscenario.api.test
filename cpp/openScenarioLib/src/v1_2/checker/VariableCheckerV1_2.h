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

 /** */
#pragma once

#include "ICheckerRule.h"
#include "IParserMessageLogger.h"
#include "ParserHelper.h"
#include "ApiClassImplV1_2.h"
#include "ITreeMessageLogger.h"
#include <set>
#include "ScenarioCheckerImplV1_2.h"
#include "MemLeakDetection.h"

/**
 * Checks Parameter declarations' value to be parsable (not empty value)
 */
namespace NET_ASAM_OPENSCENARIO
{
    namespace v1_2
    {

		class VariableCheckerHelper 
		{
		public:
			static void ValidateParsing(std::string value, const ParameterType& parameterType);
			static std::shared_ptr<IVariableDeclaration> GetVariableDeclarationByName(const std::set<std::shared_ptr<IVariableDeclaration>>& setToSearch, const std::string& name);

		};

        class VariableDeclarationChecker : public ICheckerRule
        {
        private:
			std::shared_ptr <std::set<std::shared_ptr<IVariableDeclaration>>> definedVariables;

        	// set of Strings
        public:
			VariableDeclarationChecker(std::shared_ptr < std::set<std::shared_ptr<IVariableDeclaration>>> definedVariables);
			void ApplyRuleInFileContext(std::shared_ptr<IParserMessageLogger> messageLogger, std::shared_ptr<IOpenScenarioModelElement > object) override;
			void ApplyRuleInTreeContext(std::shared_ptr<ITreeMessageLogger > messageLogger, std::shared_ptr<IOpenScenarioModelElement> object) override;

        };

		class VariableActionChecker : public ICheckerRule
		{
		private:
			std::shared_ptr < std::set<std::shared_ptr<IVariableDeclaration>>> definedVariables;

			

		public:
			VariableActionChecker(std::shared_ptr < std::set<std::shared_ptr<IVariableDeclaration>>> definedVariables);
			void ApplyRuleInFileContext(std::shared_ptr<IParserMessageLogger> messageLogger, std::shared_ptr<IOpenScenarioModelElement > object) override;
			void ApplyRuleInTreeContext(std::shared_ptr<ITreeMessageLogger > messageLogger, std::shared_ptr<IOpenScenarioModelElement> object) override;
		};

		class VariableChecker : public ScenarioCheckerImpl
		{

		public:
			VariableChecker();


		};
    }
}