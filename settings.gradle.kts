rootProject.name = "one-more-pet-clinic"

include("domain")
include("application")
include("port-input")
include("port-output")
include("adapter-input")
include("adapter-output")
include("bootstrap")
include("architecture-tests")

project(":port-input").projectDir = file("port/input")
project(":port-output").projectDir = file("port/output")
project(":adapter-input").projectDir = file("adapter/input")
project(":adapter-output").projectDir = file("adapter/output")
