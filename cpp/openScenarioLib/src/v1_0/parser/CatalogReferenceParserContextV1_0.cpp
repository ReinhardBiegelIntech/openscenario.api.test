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


#include "CatalogReferenceParserContextV1_0.h"
#include <vector>
#include "MemLeakDetection.h"

namespace NET_ASAM_OPENSCENARIO
{
    namespace v1_0
    {
       
       void CatalogReferenceParserContext::AddCatalogReference(const std::shared_ptr<ICatalogReference> catalogReference)
        {
            _catalogReferences.push_back(catalogReference);
        }

        std::vector<std::shared_ptr<ICatalogReference>> CatalogReferenceParserContext::GetCatalogReferences()
        {
            return _catalogReferences;
        }


    }
}
