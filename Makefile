.DEFAULT_GOAL := build-docker

build-docker:
	./mvnw package
	docker build -t service/arithmetic .

run-docker:
	docker run -p 8080:8080 service/arithmetic
