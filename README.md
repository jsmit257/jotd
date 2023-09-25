## Joke Of The Day
A simple service to read and update a Joke Of The Day.  Currently runs as standalone on a workstation with `make`, `sqlite3` and any +Java6 version.

#### Requirments (standalone and docker)
- make
- sqlite3

#### Optional (docker only)
- docker
- docker-compose

### Starting

#### Standalone
Run `make run-local` to start the server; Default settings bind to localhost:8080 but can be changed in the `run-local` target in `Makefile`; This target:
- deletes any existing jotd database, unless the `NO_CLOBBER_DB` env var is non-empty
- creates the new database and seeds data
- starts the server as a local process

#### Docker
Run `fun-docker` to start the postgres service and the jotd server; Default host and port are the same and can be modified in `docker-compose.yml`; This target:
- stops any existing services in this `docker-compose.yml`
- starts a postgres service called `jotd-db`
- applies the jotd schema to the postgres instance (after a pause)
- starts the jotd server in a `jotd-api` service

#### Using
`curl` is the current method for accessing the service; A web UI is in the works, but needs some work still; Comprehensive examples of using the service can be found in (./bin/tests); One weirdness is that every request requires a body - perhaps requiring `day` as a URL parameter for each request would've been more normal, but the code stays cleaner this way

Some simple examples from (./bin/tests) follow:
- fetch a joke for the given day
```sh
curl -i -XGET http://localhost:8080/jotd -d '{"day":"2023-09-23"}'
```
- create a joke
```sh
curl -i -XPOST http://localhost:8080/jotd -d '{"day":"2023-09-25","text":"not funny"}'

```

### Testing
As mentioned above, (./bin/tests) is the only current test; It runs at the system level and can exercise all the errors except `SQLException`; And it lacks proper automation, so a human has to review the expected v. actual results

#### TODO:
- use `IJokes` to create mocks for unit tests in `http` package
- figure out how to mock `Connection`, `PreparedStatement`, etc to create unit tests for the data layer
- create a properly automated system test with clear results
