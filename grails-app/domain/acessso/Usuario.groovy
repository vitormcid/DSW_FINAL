package acessso

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class Usuario implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService
        
        
        String cpf
        String email
        int idade
	String username
	String password
        boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
        float pontuacao

	Usuario(String username, String password) {
		this()
		this.username = username
		this.password = password
	}

	Set<Papel> getAuthorities() {
		UsuarioPapel.findAllByUsuario(this)*.papel
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']

	static constraints = {
		password blank: false, password: true
		username blank: false, unique: true
                pontuacao blank: true               
	}

	static mapping = {
		password column: '`password`'
	}
}
