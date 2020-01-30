# template-selenium-2
Basic startup architecture for selenium project


# To run Project
put an API_KEY from appli tools, inside conf.properties, configure the right resolution of the applitools batch

Go to src > test > GoogleTest > run the class

# SeleniumAbstraction
Some abstractions for selenium framework
Every time when you create a pageobject or TaskObject, extends SeleniumAbstraction, because it's responsible to create the instance of the Driver.

# ConstantsProperties
Every properties inside the conf.properties must have an attribute inside the ConstantsProperties class

# Browser
return the browser, simple as that>


