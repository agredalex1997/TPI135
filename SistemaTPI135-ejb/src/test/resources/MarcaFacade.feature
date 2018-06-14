Feature: Probar EJB Marca
Probar el ejb de Marca
    Scenario: crear una entidad Marca
        Given tengo un nuevo objeto Marca 1, "Lenovo", "true", "" 
        When hago una peticion para crear
        Then obtengo el estado creado

    Scenario: editar una entidad Marca
        Given tengo un objeto Marca "Lenovo", "true", ""
        When hago una peticion para editar
        Then obtengo un estado editado

    Scenario: eliminar una entidad Marca
        When tengo un id 
        Then hago una peticion para eliminar
        Then obtengo un estado eliminado

    Scenario: Obtener una entidad Marca por id
        When tengo un id Marca
        Then hago una peticion para buscar
        Then obtengo una entidad Marca
        
    Scenario: obtener una lista de entidades Marca
        When hago una peticion
        Then obtengo una lista

    Scenario: obtener una lista de entidades Marca por rango
        When tengo un rango 2,4
        Then hago una peticion con el rango
        Then obtengo una lista de entidades por rango

    Scenario: obtener numero de entidades
        When hago una peticion para obtener el numero de entidades
        Then obtengo el numero de entidades
     
    Scenario: obtener una lista entidades Marca por nombre
        When tengo un nombre "a"
        Then hago una peticion con el nombre
        Then obtengo una lista por nombres