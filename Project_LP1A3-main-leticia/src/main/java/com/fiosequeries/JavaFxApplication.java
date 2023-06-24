package com.fiosequeries;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class JavaFxApplication extends Application {

	private ConfigurableApplicationContext context;

	@Override
	public void init() {
		ApplicationContextInitializer<GenericApplicationContext> initializer =
				context -> {
					context.registerBean(Application.class, () -> JavaFxApplication.this);
					context.registerBean(Parameters.class, this::getParameters);
					context.registerBean(HostServices.class, this::getHostServices);
				};
		this.context = new SpringApplicationBuilder()
				.sources(BootifulFxApplication.class)
				.initializers(initializer)
				.run(getParameters().getRaw().toArray(new String[0]));
	}

	@Override
	public void start(Stage stage) throws IOException {
		this.context.publishEvent(new StageReadyEvent(stage));
	}

	@Override
	public void stop() throws Exception {
		this.context.close();
		Platform.exit();
	}
}

@Log4j2
@Component
class StageInitializer implements ApplicationListener<StageReadyEvent> {

	private final String applicationTitle;
	private final ApplicationContext applicationContext;

	StageInitializer(@Value("${spring.application.ui.title}") String applicationTitle,
					 ApplicationContext applicationContext) {
		this.applicationTitle = applicationTitle;
		this.applicationContext = applicationContext;
	}

	private Stage currentStage;

	public void changeScene(String fxmlPath) {
		try {
			ClassPathResource fxml = new ClassPathResource(fxmlPath);
			FXMLLoader fxmlLoader = new FXMLLoader(fxml.getURL());
			fxmlLoader.setControllerFactory(this.applicationContext::getBean);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root, 600, 400);
			Stage stage = new Stage();  // Cria um novo estágio para a nova cena
			stage.setScene(scene);
			stage.setTitle(this.applicationTitle);
			stage.show();

			// Fecha o estágio atual e limpa a referência
			if (currentStage != null) {
				currentStage.close();
				currentStage = null;
			}

			// Atualiza a referência do estágio atual
			currentStage = stage;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public void onApplicationEvent(StageReadyEvent stageReadyEvent) {
		try {
			Stage stage = stageReadyEvent.getStage();
			ClassPathResource fxml = new ClassPathResource("/GerenciaPedidoOrcamento.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxml.getURL());
			fxmlLoader.setControllerFactory(this.applicationContext::getBean);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root, 600, 400);
			stage.setScene(scene);
			stage.setTitle(this.applicationTitle);
			stage.show();
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

class StageReadyEvent extends ApplicationEvent {

	private static Stage stage;

	StageReadyEvent(Stage stage) {
		super(stage);
		this.stage = stage;
	}

	public Stage getStage() {
		return stage;
	}
}