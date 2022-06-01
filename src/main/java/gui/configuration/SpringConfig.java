package gui.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Konfigurationen für den Spring-Servers
 * 
 * @author mmo
 */
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan
public class SpringConfig
{
	// @Autowired
	// private Environment env;
	//
	// /**
	// * @return Möglichkeit zum Auflösen von Konfigurationen mittels <code>{@value config}</code>
	// */
	// @Bean
	// public static PropertySourcesPlaceholderConfigurer placeholderConfigurer()
	// {
	// return new PropertySourcesPlaceholderConfigurer();
	// }
	//
	// /**
	// * Konfiguriert die Datenquelle
	// *
	// * @return Datenquelle als {@link DataSource}
	// */
	// @Bean
	// public DataSource getDataSource()
	// {
	// DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
	//
	// dataSourceBuilder.url(env.getProperty("spring.datasource.url"));
	// dataSourceBuilder.username(env.getProperty("spring.datasource.username"));
	// dataSourceBuilder.password(env.getProperty("spring.datasource.password"));
	// return dataSourceBuilder.build();
	// }
}
