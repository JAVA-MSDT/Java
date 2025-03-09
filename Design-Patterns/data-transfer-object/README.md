# data-transfer-object
Data Transfer Object (DTO) 
## DTOs
 * Are objects that carry data between processes in order to reduce the number of methods calls.
## Benefits
 * Reduceing roundtrips to the server by batching up multiple parameters in a single call.
 * Collecting data from multiple sources then sending them as one response.
 * Isolating the Domain object from the representational object, by this way you control what data to send to the representational layer for security or other reasons.
## Use cases
 * When you need to have different representational for the same object.
 * When you have different calls to different objects, but you need to combine the end results in one object.
## Advices of use
 * they are only transportation layer, so no need to add logics there.
 * Try to avoid making a lot of different representations layer using DTOs to avoid having a lot DTOs later and that leads to mass of complexity.
 
