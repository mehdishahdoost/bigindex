### Kafka Delivery Methods

* At-least-Once semantics: A message is sent as needed until it is acknowledged.
* At-most-once semantics: A message is only sent once and not resent on failure.
* Exactly-once (EOS) semantics: A message is only seen once by the consumer of the message.
