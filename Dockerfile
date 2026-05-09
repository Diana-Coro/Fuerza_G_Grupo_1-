FROM ubuntu:latest
LABEL authors="alfredo"

ENTRYPOINT ["top", "-b"]