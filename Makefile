all: 
	bash update-version.sh
clean:
	rm -rf lib .tmp
run:
	gradle bootRun
