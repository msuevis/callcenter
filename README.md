# callcenter

Para el desarrollo de este proyecto se decidio usar una arquitectura integracion basada en colas de servicios  especificamente empleadon un Canal ( Point-to-Point ) este tipo de arquitectura asegura que un solo receptor consuma un mensaje determinado, si el canal tiene multiples receptors solo uno de ellos podra consumir con exito un mensaje determinado. 

dada la complejidad añadida al ejercicio en el cual se establecio la prioridad que deben tener los operadores sobre los demas tipos de empleados al responder una llama fue necesario establece un tipo especial de consumidor de mensaje, el cual fuera capaz de entregar el mensaje a los destinatarios con la prioridad mas alta dentro del sistema para esto se implement un tipo especial de consumidor llamado Message Dispacher encargado de asociar los mensajes optenidos de la cola con su respective receptor u/o empleado. 

En el siguiente diagram de secuencia se muestra el flujo que tiene el sistema de mensajeria para entregar un mensaje utilizando un message dispatcher para controlar la logica de entrega de los mensajes :

EL Message Dispatcher es el encargado de entregar los mensajes recuperados del canal para su posterior entrega hacia los posibles destinatarios.

Para evitar tener que crear una sonda que este preguntando cada sierto tiempo si un mensaje o una llamada fue recivida se decidio implementar un tipo de consumidor especial basado en eventos y se convino con el message dispatcher la caracteristica principal del consumidor basado en eventos es que no espera a que los mensajes esten en la cola para irlos a recuperar si no que se le notifica cada vez que un mensaje es recivido para que Dispatcher recupere este y lo entregue a el destinatario correspondiente.

Utilizando este tipo de arquitectura pudimos desacoplar a los productores de mensajes de sus respectivos consumidores teniendo una arquitectura bajamente acoplada .

