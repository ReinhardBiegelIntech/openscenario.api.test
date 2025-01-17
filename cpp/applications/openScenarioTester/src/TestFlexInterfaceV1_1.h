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

#pragma once
#include "TestBaseV1_1.h"
namespace NET_ASAM_OPENSCENARIO
{
    namespace v1_1
	{
		class TestFlexInterface : public TestBase
		{
		public:

			TestFlexInterface(std::string& executablePath);

			bool TestExample();

		private:

			std::shared_ptr<ITransitionDynamics> GetSpeedActionDynamics(std::shared_ptr<IOpenScenario> openScenario, bool& res);

			// ReSharper disable once CppMemberFunctionMayBeStatic
			std::shared_ptr<IEvent> GetEvent(std::shared_ptr<IOpenScenario> openScenario);

			// ReSharper disable once CppMemberFunctionMayBeStatic
			std::shared_ptr<IRelativeLanePosition> GetRelativeLanePosition(std::shared_ptr<IEvent> eventPtr);
			// ReSharper disable once CppMemberFunctionMayBeStatic
			std::shared_ptr<IActors> GetActors(std::shared_ptr<IOpenScenario> openScenario);

			template <typename T>
			// ReSharper disable once CppMemberFunctionMayBeStatic
			bool AssertException(NET_ASAM_OPENSCENARIO::IOpenScenarioFlexElement* flexElement, T f)
			{
				bool exceptionThrown = false;
				try
				{
					f(flexElement);
				}
				catch (NET_ASAM_OPENSCENARIO::KeyNotSupportedException& e)
				{
					(void)e;
					exceptionThrown = true;
				}

				return Assert(exceptionThrown, ASSERT_LOCATION);
			}
		};
	}
}