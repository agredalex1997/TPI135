Feature: Probar Rest Area
Probar el resource de Area
    Scenario: crear una entidad area
	Given tengo un objeto area con id, nombre, observacion 6 AND "Economía" AND " "
	When hago una peticion para crear
        Then obtengo un estado de creado

    Scenario: editar una entidad area
        Given tengo un objeto area con nombre, observacion "Matematicas" AND " "
        When selecciono un id 6
        Then hago una peticion para editar
        Then obtengo un estado de modificado

    Scenario: eliminar una entidad area
        When seleciono un id 6
        Then hago una peticion para eliminar
        Then obtengo un estado de eliminado

    Scenario: obtener una entidad area
        When tengo un id 1
        Then hago una peticion para obtener una entidad
        Then obtengo una entidad

    Scenario: obtener una lista de entidades
        When hago una peticion para obtener todo
        Then obtengo una lista de areas

    Scenario: obtener lista de entidades por rango
        When tengo un rango desde, hata 2, 4
        Then hago una peticion con el rango
        Then obtengo una lista por rango

    Scenario: obtener el numero de numero entidades registradas
        When hago una peticion para contar
        Then obtengo el numero de entidades 
        
    Scenario: Obtner una lista de areas por nombre
        When tengo una cadena de texto "e"
        Then hago una peticion con la cadena obtenida
        Then obtengo una lista por nombres
