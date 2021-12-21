FROM node:6.14.2
EXPOSE 8080
COPY server.js .
EXPOSE 8080
CMD node server.js
