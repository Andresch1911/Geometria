package Principal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.converter.NumberStringConverter;

public class TrianguloController extends VBox {

	private TextField baseText;
	private TextField alturaText;

	private Label areaLabel;

	private Triangle trianguloShape;

	private TrianguloModel trianguloModel = new TrianguloModel(20.0, 20.0);

	public TrianguloController() {
		super();

		baseText = new TextField();
		baseText.setPrefColumnCount(5);

		HBox baseBox = new HBox(5, new Label("Base:"), baseText);
		baseBox.setAlignment(Pos.BASELINE_CENTER);

		alturaText = new TextField();
		alturaText.setPrefColumnCount(5);

		HBox alturaBox = new HBox(5, new Label("Altura:"), alturaText);
		alturaBox.setAlignment(Pos.BASELINE_CENTER);

		areaLabel = new Label("[?] Sin definir");
		HBox areaBox = new HBox(5, new Label("Área:"), areaLabel);
		areaBox.setAlignment(Pos.BASELINE_CENTER);

		trianguloShape = new Triangle();
		trianguloShape.setFill(Color.AQUAMARINE);
		trianguloShape.setStroke(Color.DARKBLUE);
		trianguloShape.setStrokeWidth(2);

		this.setSpacing(5);
		this.setAlignment(Pos.TOP_CENTER);
		this.getChildren().addAll(baseBox, alturaBox, trianguloShape, areaBox);
		this.setPadding(new Insets(5));

		baseText.textProperty().bindBidirectional(trianguloModel.baseProperty(), new NumberStringConverter());
		alturaText.textProperty().bindBidirectional(trianguloModel.alturaProperty(), new NumberStringConverter());

		areaLabel.textProperty().bind(trianguloModel.areaProperty().asString());

		trianguloShape.baseProperty().bind(trianguloModel.baseProperty());
		trianguloShape.heightProperty().bind(trianguloModel.alturaProperty());

	}

}
