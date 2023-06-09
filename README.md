<h1 align="center">

Analisador Léxico

</h1>

<p align="center">
  Implementação de um Analisador Léxico para reconhecimento de tokens da linguagem OWL2 (Web Ontology Language) no formato Manchester Syntax.
</p>

<h4 align="center">
	🖥️&nbsp; Compiladores 🖥️ </br>
</h4>


Sumario
=================
<!--ts-->
   * [💡 O que é um Analisador Lexico?](#question)
   * [🛠 OWL e Manchester Syntax](#OWL)
   * [:gear:  Implementação ](#implementation)
   * [:memo: Funções ](#function)
   * [👨‍💻 Autores](#authors)
<!--te-->
</br>
<h2 id="question">💡 O que é um Analisador Lexico?</h2>
Um analisador léxico, também conhecido como scanner, é uma das etapas fundamentais no processo de
compilação de um programa de computador. Ele é responsável por analisar o código-fonte do programa e 
dividir o texto em unidades léxicas, chamadas de tokens.

O analisador léxico percorre o código-fonte caractere por caractere, agrupando-os em tokens significativos.
Ele também verifica se os tokens encontrados estão de acordo com a gramática da linguagem de programação.
</br> 

<h2 id="OWL">🛠 OWL e Manchester Syntax</h2>
A linguagem OWL (Web Ontology Language) é baseada em RDF (Resource Description
Framework) e XML (eXtensible Markup Language) para relacionar recursos que têm algo a ver um com o outro
na Web. Tudo na Web é um recurso: uma página, um perfil de utilizador de redes sociais, um vídeo, um áudio,
um texto, entre outros. O nível de granularidade dos recursos na Web é vasto. Cada recurso pode ser
identificado por uma URI (Unified Resource Identifier).

</br>

Manchester Syntax, para descrição de ontologias em Description Logics:
</br>
Pizza THAT
hasTopping SOME MozzarellaTopping AND
hasTopping SOME TomatoTopping AND
hasTopping ONLY (MozzarellaTopping OR
TomatoTopping OR
PepperonniTopping)

</br>
Description Logics é a lógica de descrever coisas com base nas relações que elas têm entre si. Uma linguagem
baseada em Description Logics é geralmente declarativa, ou seja, não contém métodos ou funções de
transformação. Sendo assim, os conceitos de uma ontologia, por exemplo, são descritos sequencialmente, como
declarações avulsas. Um motor de inferência (reasoner) lê essas declarações e realiza inferências sobre
relações implícitas que poderiam conectar ainda mais os conceitos de uma ontologia. 


<h2 id="implementation">:gear: Implementação</h2>
Nosso analisador lexico tem com objetivo o reconhecimento de tokens da linguagem OWL2 (Web Ontology
Language) no formato Manchester Syntax. O programa é feito em java e utiliza de REGEX para reconhecer os tokens e seus determinados tipos.


</br>

<h2 id="function">:memo: Funções</h2>
Resumo das funções utilizadas na implementação:

- <h3>iniciarPalavrasReservadas</h3>
Primeira Função do arquivo que inicial o vetor de palavras reservadas sendo elas:

  - SOME
  - ALL
  - VALUE
  - MIN
  - MAX
  - EXACTLY
  - NOT 
  - AND
  - OR 

- <h3>readFile</h3>
Essa função recebe um path para um arquivo txt contendo a ontologia em formato Manchester Synta, lê as linhas do arquivo separando os tokens e os armazenando em um array
- <h3>returnType</h3>
Retorna o tipo do token (PALAVRA RESERVADA, CLASSE, PROPRIEDADE, NUMERO OU DESCONHECIDO) baseado na alise de REGEX
- <h3>drawTable e padRight</h3>
Funções para desenhar a tabela de tokens e tipos no terminal para melhor vizualização.
</br>

<h2 id="authors">👨‍💻 Autores</h2>

<table>
  <tr>
	<td align="center">
	      <a href="https://github.com/Rigobertto">
		<img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/54067766?v=4" width="100px;" alt=""/>
		<br /><sub><b>👩‍💻 Rigoberto</b></sub>
	      </a>
	</td>
    <td align="center">
      <a href="https://github.com/isabeleLima">
        <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/58983203?v=4" width="100px;" alt=""/>
        <br /><sub><b>👩‍💻 Isabele Cristina</b></sub>
      </a>
    </td>
	<td align="center">
	      <a href="https://github.com/KennedyEduRG">
		<img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/112023497?v=4" width="100px;" alt=""/>
		<br /><sub><b>👩‍💻 Kennedy</b></sub>
	      </a>
	    </td>
	<td align="center">
      <a href="https://github.com/pslayne">
        <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/58180438?v=4" width="100px;" alt=""/>
        <br /><sub><b>👩‍💻 Layne</b></sub>
      </a>
    </td>
  </tr>
</table>
