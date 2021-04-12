package CSVValidation
package traits

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.ObjectNode

object ObjectNodeExtentions {
  implicit class IteratorHasGetKeysAndValues(objectNode: ObjectNode) {
    /** Get the (key, value) pairs from a Jackson ObjectNode **/
    def getKeysAndValues: Array[(String, JsonNode)] =
      JavaIteratorExtensions.IteratorHasAsScalaArray(objectNode.fields())
        .asScalaArray
        .map(kvp => (kvp.getKey, kvp.getValue))
  }
}
