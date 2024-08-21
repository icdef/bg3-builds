FROM node:alpine

WORKDIR /usr/src/app

RUN npm install -g @angular/cli

COPY frontend /usr/src/app

RUN npm install

CMD ["ng", "serve", "--host", "0.0.0.0"]