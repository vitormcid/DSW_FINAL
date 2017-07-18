package anac

import anac.Questao
import grails.transaction.Transactional
import org.springframework.security.access.annotation.Secured
import acessso.Usuario

@Transactional(readOnly = true)
@Secured ('ROLE_USER')
class QuestionarioController {
    
    def nAcertos=-1
    def contador=0
    def index() {
       
     def sel=params.alternativa
        
     def questoes = Questao.list()
     def number=0
     if (params.value!= null){
          number=Integer.parseInt(params.value)
          contador++
     }    
     if (nAcertos == null)
          nAcertos=0
     else if(sel==params.resp)
        nAcertos=nAcertos+1
        
        [questoes:questoes,nAcertos:nAcertos,contador:contador]
        
   }
}

