package Principal;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.converter.NumberStringConverter;

public class CirculoController extends VBox {
	private TextField radioText;

	private Label areaLabel;

	private Circle circleShape;

	private CirculoModel circuloModel = new CirculoModel(20.0);

	public CirculoController() {
		super();

		radioText = new TextField();

		HBox radioBox = new HBox(5, new Label("Radio:"), radioText);
		radioBox.setAlignment(Pos.BASELINE_CENTER);

		circleShape = new Circle();
		circleShape.setFill(Color.RED);
		circleShape.setStroke(Color.DARKBLUE);
		circleShape.setStrokeWidth(2);
		areaLabel = new Label("[?] Sin definir");
		HBox areaBox = new HBox(5, new Label("Área:"), areaLabel);
		areaBox.setAlignment(Pos.BASELINE_CENTER);
		this.setSpacing(5);
		this.setAlignment(Pos.TOP_CENTER);
		this.getChildren().addAll(radioBox, circleShape, areaBox);
		this.setPadding(new Insets(5));

		radioText.textProperty().bindBidirectional(circuloModel.radioProperty(), new NumberStringConverter());
		circleShape.radiusProperty().bind(circuloModel.radioProperty());
		areaLabel.textProperty().bind(Bindings.format("%,.2f", circuloModel.areaProperty()));

	}

}
