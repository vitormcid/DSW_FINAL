package anac
import org.springframework.security.access.annotation.Secured

/*

class LoginController {

    def springSecurityService

    def index() {


        def usuario = springSecurityService.getCurrentUser()
        def authority = usuario.getAuthorities()[0].getAuthority()
        session.usuario = usuario

        if (authority.equals('ROLE_USER')) {
            //redirect(controller: "Usuario",action: "create")
            redirect(controller: "Usuario")
        } else {
            redirect(controller: "Questao")
        }
    }
}
*/


@Secured (['ROLE_USER', 'ROLE_ADMIN'])
class MainController {

    def springSecurityService

    def index() {


        def usuario = springSecurityService.getCurrentUser()
        def authority = usuario.getAuthorities()[0].getAuthority()
        session.usuario = usuario

        if (authority.equals('ROLE_USER')) {
            redirect(controller: "questionario")
        } else {
            redirect(controller: "admin")
        }
    }
}
