# TrabalhoFinalTCP
## Trabalho final Técnicas de Construção de Programas (INF01120) UFRGS
Tocador musical escrito em Java. Recebe um arquivo texto ou texto via teclado e converte em notas musicais. 

<img width="1072" alt="Screen Shot 2022-10-03 at 22 40 17" src="https://user-images.githubusercontent.com/82053045/193716274-e9280b9e-73d0-46c3-a849-2c2597ba0998.png">

---

## Início rápido
### Baixando jar executável
Baixar jar compilado e executável em [Releases](https://github.com/matheus-mcosta/TrabalhoFinalTCP/releases)

### Compilando

#### Pré-requisitos 
>[Maven](https://maven.apache.org)

```
mvn clean compile assembly:single && java -jar target/tocador-1.0-jar-with-dependencies.jar
```
---
## Uso

Botões
- Play: Converte texto visível em sons
- Stop: Para a reprodução
- Import: Abre janela para carregar arquivo de texto
- Export: Salva som gerado em um arquivo .MIDI

Conforme a legenda a seguir, digite na área de texto ou importe um arquivo de texto para tocar sons. 

<img width="1220" alt="image" src="https://user-images.githubusercontent.com/82053045/193715921-54de0e17-0e7f-417b-8472-e5693b0ae413.png">
