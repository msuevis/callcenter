# callcenter

Para el desarrollo de este proyecto se decidió usar una arquitectura integración basada en colas de servicios  específicamente empleando un Canal ( Point-to-Point ) este tipo de arquitectura asegura que un solo receptor consuma un mensaje determinado, si el canal tiene múltiples receptor solo uno de ellos podrá consumir con éxito un mensaje determinado.

![image](https://user-images.githubusercontent.com/7049271/38065752-8a5b0830-32ca-11e8-807f-15dfbd757e19.png)

Dada la complejidad añadida al ejercicio en el cual se estableció la prioridad que deben tener los operadores sobre los demás tipos de empleados al responder una llama fue necesario establece un tipo especial de consumidor de mensaje, el cual fuera capaz de entregar el mensaje a los destinatarios con la prioridad más alta dentro del sistema para esto se implementó un tipo especial de consumidor llamado Message Dispacher encargado de asociar los mensajes obtenidos de la cola con su respectiva receptor u/o empleado. 

En el siguiente diagrama de secuencia se muestra el flujo que tiene el sistema de mensajería para entregar un mensaje utilizando un message dispatcher para controlar la lógica de entrega de los mensajes :

![image](https://user-images.githubusercontent.com/7049271/38065983-7d1bea08-32cb-11e8-83df-d9576ece24f7.png)

EL Message Dispatcher es el encargado de entregar los mensajes recuperados del canal para su posterior entrega hacia los posibles destinatarios.

Para evitar tener que crear una sonda que este preguntando cada cierto tiempo si un mensaje o una llamada fue recibida se decidió implementar un tipo de consumidor especial basado en eventos y se convino con el message dispatcher la característica principal del consumidor basado en eventos es que no espera a que los mensajes estén en la cola para irlos a recuperar si no que se le notifica cada vez que un mensaje es recibido para que Dispatcher recupere este y lo entregue a el destinatario correspondiente.

Utilizando este tipo de arquitectura pudimos desacoplar a los productores de mensajes de sus respectivos consumidores teniendo una arquitectura bajamente acoplada.

![image](https://user-images.githubusercontent.com/7049271/38066023-a3fa4e08-32cb-11e8-8e56-b92a2c1fe630.png)
