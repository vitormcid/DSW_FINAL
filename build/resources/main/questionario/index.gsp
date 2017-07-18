<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<%@page import="java.util.*" %>
<%
Random rand = new Random();
int n = rand.nextInt(4)+1;
System.out.println("numero de acertos="+contador);

%>


<html>
    <head>
        <style>p.indent{ padding-left: 1.8em }</style>
        <meta name="layout" content="main" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sample title</title>
    </head>
    <body>
        
        <g:each in="${questoes}" var="questao" status="i">

            
            <g:form controller="questionario"> 
            <g:if test="${questao.id == n}">
               <p class="indent">
               <br/>${questao.enunciado}<br/><br/>
              <input type="radio" name="alternativa" value="1" checked>1.${questao.alt1}<br>
              <input type="radio" name="alternativa" value="2" checked>2.${questao.alt2}<br>
              <input type="radio" name="alternativa" value="3" checked>3.${questao.alt3}<br>
              <input type="radio" name="alternativa" value="4" checked>4.${questao.alt4}<br>
              <input type="radio" name="alternativa" value="5" checked>5.${questao.alt5}<br>
              
             <input type="hidden" name="resp" value=${questao.resposta} >
                            
             </p>
             
            <br/>
            <br/>
            
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"  role="button" aria-haspopup="true" aria-expanded="false"><g:message code="awnser"/><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">${questao.resposta}</a></li>
                    </ul>    
            </li>
            
            <br/>
            <br/>
            <center><g:message code="score"/> :${nAcertos} de ${contador}</center>
            
            <div id="form" class="content scaffold-create" role="main">
             
            <fieldset class="buttons">
               
                <g:field name="value" type="number" value="1" type="hidden"/>
                               
                <g:submitButton name="OK" class="OK" value="Proxima"/>
                
            </fieldset>    
           
            </div>

            
            
           
       
            <center><li><g:link controller="logout"><g:message code="Logout"/></g:link></li></center>
            
            </g:if> 
           </g:form>
       </g:each>
    </body>
</html>
