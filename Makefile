JAVA_LIBS=lib/javaee-api-8.0.jar:lib/hamcrest-core-2.2.jar:lib/json-20230618.jar:lib/junit-4.13.2.jar:lib/postgresql-42.6.0.jar:lib/slf4j-api-2.0.7.jar:lib/slf4j-simple-2.0.7.jar:lib/sqlite-jdbc-3.43.0.0.jar

.PHONY: initdb
initdb:
	./bin/init-sqlite

.PHONY: clean
clean:
	@find . -name '*.class' -exec rm -v '{}' \;

.PHONY: build
build: clean
	javac -Xlint:deprecation -cp $(JAVA_LIBS) `find . -name '*.java'`

.PHONY: unit
unit: build

.PHONY: package
package: build
	jar cf lib/jotd.jar `find com -name '*.class'` jotd*.properties

.PHONY: run-local
run-local: package initdb
	JOTD_CONFIG=local_standalone SERVER_HOST=localhost SERVER_PORT=8080 java -cp lib/jotd.jar:$(JAVA_LIBS) com.jotd.cmd.JOTD

.PHONY: deploy
deploy:

.PHONY: run-docker
run-docker: docker-down package
	docker-compose -f docker-compose.yml up --detach postgres
	@echo "give postgres a few seconds to start" >&2
	sleep 7s
	docker-compose -f docker-compose.yml up test-serve-jotd

.PHONY: tests
tests:
	./bin/tests

.PHONY: docker-down
docker-down:
	docker-compose -f docker-compose.yml down
