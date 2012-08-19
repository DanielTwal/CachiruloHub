package hub

class RecoveryPassController {
	def mailService
    def index() { }
	
	def save() {
		def company = Company.findByEmail(params['email'])
		def pass = org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10)
		
		company.password = Company.encrypt(pass)
		
		if(!company.save(flush:true)){
			render(model: [company: company], view: 'index')
			return
		}
		
		mailService.sendMail {
		  to company.email
		  subject "[CachiruloHub] Recuperacion de contraseña"
		  html g.render(template:"/mails/recoveryPass", model:[pass: pass])
		}
		
		redirect(controller:'company', action:'edit', id: company.id)
	}
}
