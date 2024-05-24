### Install Confluent CLI

```
brew install confluentinc/tap/cli
```

### Start a single node kafka cluster with confluent CLI

```
confluent local kafka start
confluent local kafka topic create quickstart
confluent local kafka topic produce quickstart
confluent local kafka topic consume quickstart --from-beginning
confluent local kafka stop
```

### Login into Confluent Cloud

```
confluent login
```

### List clusters

```
confluent kafka cluster list
```

### Set active cluster via Confluent CLI

```
confluent kafka cluster use <cluster-Id>
```

### Create API-Key

```
confluent api-key create --resource <cluster ID>
confluent api-key use <API key> --resource <cluster ID>
```

### Kafka key-value

Kafka works with key-value pairs, but so far you’ve only sent records with values only. Well to be fair you’ve sent key-value pairs, but the keys are null. Sometimes you’ll need to send a valid key in addition to the value from the command line.

```
confluent local kafka topic produce orders --parse-key --delimiter "-"
confluent local kafka topic consume orders --print-key --from-beginning

```

