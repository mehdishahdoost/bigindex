### Install psql in macos

```
brew install libpq
brew link --force libpq
```

### Connect to postgres database via psql

```
PGPASSWORD=pw psql -U user -h localhost -p 5432
```
