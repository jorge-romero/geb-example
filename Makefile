.DEFAULT_GOAL := help
REACT_APP_DIR := react-app
GEB_APP_DIR := geb-app
build_app:
	cd $(REACT_APP_DIR)  && \
		   	npm install && \
			npm build
.PHONY: build_app

launch:	build_app
	cd $(REACT_APP_DIR)  && \
	npm start 
.PHONY: launch

test:
	cd $(GEB_APP_DIR) && \
			./gradlew chromeTest
.PHONY: test
help:
	@ echo 'Usage'
	@ echo '  make <target>'
	@ echo ''
	@ echo 'Targets:'
	@ echo '  make launch             : Launch server'
	@ echo '  make test               : Using the Chrome Headless by default'
	@ echo '  make testChrome         : Chrome displaying the browser '
	@ echo '  make testChromeHeadless : Chrome without displaying the browser'
.PHONY: help

