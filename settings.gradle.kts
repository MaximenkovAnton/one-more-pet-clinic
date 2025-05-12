rootProject.name = "one-more-pet-clinic"

// Основные модули
include("domain")
project(":domain").projectDir = file("modules/core/domain")

include("application")
project(":application").projectDir = file("modules/core/application")

// Порты
include("port-input")
project(":port-input").projectDir = file("modules/ports/input")

include("port-output")
project(":port-output").projectDir = file("modules/ports/output")

// Адаптеры
include("adapter-input")
project(":adapter-input").projectDir = file("modules/adapters/input")

include("adapter-output")
project(":adapter-output").projectDir = file("modules/adapters/output")

// Bootstrap
include("bootstrap")
project(":bootstrap").projectDir = file("modules/bootstrap")

// Тесты
include("architecture-tests")
project(":architecture-tests").projectDir = file("modules/test/architecture")

// Тестовые утилиты
include("test-utils")
project(":test-utils").projectDir = file("modules/test/utils")

include("test-utils-domain")
project(":test-utils-domain").projectDir = file("modules/test/utils/domain")
