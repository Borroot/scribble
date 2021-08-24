package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


/**
 * @author Bram Pulles
 * This program can be used to play Scribble. A file with a lot of words is used to select and show three random words.
 * One of these three words is selected by the player to play a round of Scribble.
 *
 */

public class Main extends Application {

	private static final int AMOUNTOFWORDS = 10;

	private BorderPane templatePane = new BorderPane();
	private VBox wordsPane = new VBox(10);

	private Button btNextWords = new Button("New Words");

	private Words words = new Words(AMOUNTOFWORDS);

	private boolean chosen; // used to indicate if a word is already chosen or not


	@Override
	public void start(Stage primaryStage) {

		setTemplatePane();

		Scene scene = new Scene(templatePane, 1600, 800);
		primaryStage.setTitle("Scribble made by Bram Pulles");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}


	/**
	 * Sets the begin screen.
	 */
	private void setTemplatePane() {

		Text titleTxt = new Text("Scribble");
		titleTxt.setFont(Font.font(150));
		templatePane.setTop(titleTxt);
		BorderPane.setAlignment(titleTxt, Pos.BOTTOM_CENTER);
		BorderPane.setMargin(titleTxt, new Insets(30));

		wordsPane.setAlignment(Pos.BASELINE_CENTER);
		templatePane.setCenter(wordsPane);
		BorderPane.setAlignment(wordsPane, Pos.BASELINE_CENTER);

		btNextWords.setFont(Font.font(50));
		templatePane.setBottom(btNextWords);
		BorderPane.setAlignment(btNextWords, Pos.BASELINE_RIGHT);
		BorderPane.setMargin(btNextWords, new Insets(0, 60, 20, 0));
		btNextWords.setOnAction(e -> setWordsPane());

	}

	/**
	 * Whenever the 'next words' button is clicked this method is activated. It shows some words.
	 * When the player clicks on one of those words it turns bold.
	 */
	private void setWordsPane() {

		chosen = false;

		wordsPane.getChildren().clear();
		words.resetWords();
		String[] randomWords = words.getWords();

		for(int i = 0; i < AMOUNTOFWORDS; i++) {

			Text wordTxt = new Text(randomWords[i]);
			wordTxt.setFont(Font.font(30));

			wordTxt.setOnMouseClicked(e -> {
				if(!chosen) {
					wordTxt.setFont(Font.font(null, FontWeight.BOLD, 30));
					chosen = true;
				}
			});

			wordsPane.getChildren().add(wordTxt);
		}
	}
}
