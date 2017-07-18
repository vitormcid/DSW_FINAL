
import acessso.Papel
import acessso.Usuario
import acessso.UsuarioPapel
import anac.Questao

class BootStrap {
        
    def init = { servletContext ->
          def adminPapel = Papel.findByAuthority("ROLE_ADMIN") ?:
                new Papel(authority: "ROLE_ADMIN").save()

        def admin = new Usuario(
                username: "admin",
                password: "admin",
                name: "Administrador",
                enabled : true,
                cpf: "25222123110",
                email:"admin@hotmail.com",
                idade:22
                
        )

        admin.save()
        if (admin.hasErrors()) {
            println admin.errors
        }
        UsuarioPapel.create(admin,adminPapel)

        println 'populando usuÃ¡rio admin - ok'
        
        
        def userPapel = Papel.findByAuthority("ROLE_USER")?:
                new Papel(authority: "ROLE_USER").save()

        def ana = new Usuario(
                username: 'gustavo',
                password: 'gustavo',
                name: "Gustavo",
                enabled: true,
                cpf:'43055298918',
                email:'ana@hotmail.com',
                idade:22
        
        )
        ana.save()
        if (ana.hasErrors()) {
            println ana.errors
        }

        UsuarioPapel.create(ana,userPapel)

        println 'populando usuario ana - ok'
        
        
        def  questao= new Questao(
                enunciado: 'De acordo com o resultado da pesquisa, para atingir o maior número de consumidores das classes A/B e C/D, a empresa deve realizar a promoção, respectivamente, via:',
                resposta: '2',
                alt1: 'Correios e SMS. ',
                alt2: 'internet e Correios. ',
                alt3: 'internet e Correios. ',
                alt4: 'internet e mídias sociais.',
                alt5: 'rádio/TV e rádio/TV. '
                
        )
        questao.save()
        
        def  questao2= new Questao(
                enunciado: 'Comparando as capacidades do aquífero Guarani e desse novo reservatório da SABESP, a capacidade do aquífero Guarani é:',
                resposta: '1',
                alt1: '1,5 x 109 vezes a capacidade do reservatório novo. ',
                alt2: '1,5 x 108 vezes a capacidade do reservatório novo. ',
                alt3: '1,5 x 106 vezes a capacidade do reservatório novo ',
                alt4: '1,5 x 102 vezes a capacidade do reservatório novo. ',
                alt5: '1,5 x 103 vezes a capacidade do reservatório novo. '
          
        )
        questao2.save()
        
        def questao3 = new Questao(
            enunciado:'A emergência em que há tempo hábil para se determinar a posição em que minimiza os efeitos do impacto sobre os passageiros denomina-se:',
            alt1: 'acidental',
            alt2: 'preparada',
            alt3: 'provocada',
            alt4: 'despreparada',
            alt5: 'NDA',
            resposta:'5'
        )
        questao3.save()
        
        def questao4 = new Questao(
            enunciado: 'Despressurização significa:',
            alt1: 'Um local cuja pressão interna é zero',
            alt2: 'Entrada forçada do ar para um meio de maior pressão',
            alt3: 'A saída do ar de um meio de menor para um de maior pressão',
            alt4: 'A saída do ar de um meio de maior para um de menor pressão',
            alt5:'NDA',
            resposta:'4'
       )
       questao4.save()
       
       def questao5 = new Questao(
           enunciado: 'O oxigênio terapêutico (máscara oro-nasal) tem como finalidade:',
           alt1: 'Servir de proteção no combate ao fogo',
           alt2: 'Atender passageiros que estejam com parada circulatória',
           alt3: 'Atender passageiros e tripulantes com insuficiência respiratória',
           alt4: 'Proteger tripulantes que estejam em áreas com fumaça e/ou gases tóxicos',
           alt5: 'NDA',
           resposta:'3'
        
        ) 
        questao5.save()
        
       // int cont=0

    }
    def destroy = {
    }
}
