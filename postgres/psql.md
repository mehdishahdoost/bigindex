### Install psql in macos

```
brew install libpq
brew link --force libpq
```

### Connect to postgres database via psql

```
PGPASSWORD=pw psql -U user -h localhost -p 5432
```

### Fill database with a sql file

```
cat bootstrap.sql | PGPASSWORD=pw pgsql -U user -h localhost -p 5432 user
```
* Last "user" is schema name
