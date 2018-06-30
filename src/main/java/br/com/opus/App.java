package br.com.opus;

import br.com.opus.controller.MainController;
import br.com.opus.controller.SnippetController;
import br.com.opus.controller.SymptomController;
import org.jooby.Jooby;

/**
 * @author jooby generator
 */
public class App extends Jooby {

  {
    assets("/", "index.html");

    assets("/bower_components/**");
    assets("/js/**");
    assets("/css/**");
    assets("/html/**");
    assets("/resources/**");

    use(MainController.class);
    use(SymptomController.class);
    use(SnippetController.class);
  }

  public static void main(final String[] args) {
    run(App::new, args);
  }
}
