package masterfila.util;

import masterfila.entidade.Estabelecimento;
import masterfila.entidade.Ficha;
import masterfila.entidade.Funcionario;
import masterfila.entidade.Guiche;
import masterfila.entidade.TipoFicha;
import masterfila.entidade.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		
		Configuration configuration = new Configuration();
		
		configuration.addAnnotatedClass(Usuario.class);
		configuration.addAnnotatedClass(Ficha.class);
		configuration.addAnnotatedClass(Funcionario.class);
		configuration.addAnnotatedClass(Estabelecimento.class);
		configuration.addAnnotatedClass(TipoFicha.class);
		configuration.addAnnotatedClass(Guiche.class);
		
		configuration.configure();
		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = serviceRegistryBuilder
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static Session getSession() {
		Session session = sessionFactory.openSession();
		return session;
	}

}