require 'fox16'
require "TestProlog"
require 'open3'

include Fox

class GUI < FXMainWindow
  ##
  # Diseño General de la ventana
  ##
  def initialize(app)
    super(app,"Applicación Sencilla", :width => 350, :height => 600)

    ##########################
    # Configuracion del Menu #
    ##########################

    barra = FXMenuBar.new(self, :opts => LAYOUT_SIDE_TOP|LAYOUT_FILL_X)
    menuArch = FXMenuPane.new(self)
    FXMenuTitle.new(barra, "&Archivo", nil, menuArch)

    # Items de Menu Archivo
    menuAbre = FXMenuCommand.new(menuArch, "&Abrir..")
    menuGuarda = FXMenuCommand.new(menuArch, "&Guardar")
    menuSalir = FXMenuCommand.new(menuArch, "&Salir")

    ################################
    # Configuracion de La interfaz #
    ################################

    ##
    # Seccion de Info
    ##
    vInfo = FXVerticalFrame.new(self, :opts => LAYOUT_FILL_X)

    FXLabel.new(vInfo,"Encontrar información de una película:", :opts => LAYOUT_FILL)
    @infoPeli = FXDataTarget.new("american_beauty")
    FXTextField.new(vInfo, 25, :target => @infoPeli, :selector => FXDataTarget::ID_VALUE, :opts => LAYOUT_FILL_X)
    hInfoBtn = FXHorizontalFrame.new(vInfo,:opts => LAYOUT_CENTER_X)
    btnInfo = FXButton.new(hInfoBtn, "Buscar")

    ##
    # Seccion de agregar y eliminar movie
    ##
    vAddMovie = FXVerticalFrame.new(self, :opts => LAYOUT_FILL_X)

    FXLabel.new(vAddMovie,"Agregar - Eliminar información de una película:", :opts => LAYOUT_FILL)

    hAddMovie = FXHorizontalFrame.new(vAddMovie)
    mAddMovie = FXMatrix.new(hAddMovie,4,:opts => MATRIX_BY_COLUMNS)

    FXLabel.new(mAddMovie,"Movie:")
    @addMovie = FXDataTarget.new("broly")
    FXTextField.new(mAddMovie,15,:target => @addMovie, :selector => FXDataTarget::ID_VALUE)

    FXLabel.new(mAddMovie,"Year:")
    @addYear = FXDataTarget.new("2018")
    FXTextField.new(mAddMovie,15,:target => @addYear, :selector => FXDataTarget::ID_VALUE)

    hAddMovieBtn = FXHorizontalFrame.new(vAddMovie,:opts => LAYOUT_CENTER_X)
    btnAddMovie = FXButton.new(hAddMovieBtn, "Agregar movie")
    btnDeleteMovie = FXButton.new(hAddMovieBtn, "Eliminar movie")

    ##
    # Seccion Actualizar Movie
    ##
    vUpdateMovie = FXVerticalFrame.new(self, :opts => LAYOUT_FILL_X)

    FXLabel.new(vUpdateMovie,"Actualizar información de una película:", :opts => LAYOUT_FILL)

    hUpdateMovie = FXHorizontalFrame.new(vUpdateMovie)
    mUpdateMovie = FXMatrix.new(hUpdateMovie,4,:opts => MATRIX_BY_COLUMNS)

    FXLabel.new(mUpdateMovie,"Movie:")
    @updateMovie = FXDataTarget.new("broly")
    FXTextField.new(mUpdateMovie,15,:target => @updateMovie, :selector => FXDataTarget::ID_VALUE)

    FXLabel.new(mUpdateMovie,"New Movie:")
    @updateMovieNew = FXDataTarget.new("spiderman_far_home")
    FXTextField.new(mUpdateMovie,15,:target => @updateMovieNew, :selector => FXDataTarget::ID_VALUE)

    FXLabel.new(mUpdateMovie,"Year:")
    @updateYear = FXDataTarget.new("2018")
    FXTextField.new(mUpdateMovie,15,:target => @updateYear, :selector => FXDataTarget::ID_VALUE)

    FXLabel.new(mUpdateMovie,"New Year:")
    @updateYearNew = FXDataTarget.new("2018")
    FXTextField.new(mUpdateMovie,15,:target => @updateYearNew, :selector => FXDataTarget::ID_VALUE)

    hUpdateMovieBtn = FXHorizontalFrame.new(vUpdateMovie,:opts => LAYOUT_CENTER_X)
    btnUpdateMovie = FXButton.new(hUpdateMovieBtn, "Actualizar movie")

    ##
    # Seccion de Resultados y razonamiento
    ##
    vResultados = FXVerticalFrame.new(self, :opts => LAYOUT_FILL)
    FXLabel.new(vResultados,"Resultados", :opts => LAYOUT_FILL_X)

    FXLabel.new(vResultados,"Razonamiento de la BD", :opts => LAYOUT_FILL_X)

    hcustomQuery = FXHorizontalFrame.new(vResultados,:opts => LAYOUT_FILL_X)
    @customQuery = FXDataTarget.new("movie(M,Y)")
    FXTextField.new(hcustomQuery,15,:target => @customQuery, :selector => FXDataTarget::ID_VALUE, :opts => LAYOUT_FILL_X)

    hrazonaBtn = FXHorizontalFrame.new(vResultados,:opts => LAYOUT_CENTER_X)
    btnRazona = FXButton.new(hrazonaBtn, "Correr consulta")
    @textArea = FXText.new(vResultados, :opts => LAYOUT_FILL)

    #######################################
    ######### EVENTOS #####################
    #######################################

    ##
    # Abre un archivo de prolog mediante el menu y ejecuta un assert
    ##
    menuAbre.connect(SEL_COMMAND) do
      dialog = FXFileDialog.new(self, "Abre archivo prolog..")
      dialog.selectMode = SELECTFILE_EXISTING
      dialog.patternList = ["Archivos Prolog (*.pl)", "Archivos de texto (*.txt)", "Todos (*)"]
      if dialog.execute != 0 then
        rutaList = dialog.filename.to_s().split("\\")
        rlPos = rutaList.length - 1
        @prolog = Prolog.new(rutaList[rlPos])
        @textArea.setText("El Archivo '#{rutaList[rlPos]}' se ha leido correctamente")
      end
    end

    ##
    # Guarda conocimiento al archivo de base de datos
    ##
    menuGuarda.connect(SEL_COMMAND) do
      if validaInstancia then
        @prolog.haz("guardaEstado()")
        @textArea.setText("Guarde el estado en el archivo de movies.txt\n")
      end
    end

    ##
    #
    ##
    menuSalir.connect(SEL_COMMAND) do
      @prolog.fin()
      FXApp::ID_QUIT
    end

    ##
    #
    ##
    btnInfo.connect(SEL_COMMAND) do
      if validaInstancia then
        res = @prolog.haz("infoMovie(#{@infoPeli})")
        texto = res[0].to_s.strip
        @textArea.setText(texto)
      end
    end

    ##
    # Agrega una pelicula al razonamiento
    ##
    btnAddMovie.connect(SEL_COMMAND) do
      if validaInstancia then
        @prolog.haz("addMovie(#{@addMovie},#{@addYear})")
        @textArea.setText("movie(#{@addMovie},#{@addYear}) agregada")
      end
    end

    ##
    # elimina una pelicula al razonamiento
    ##
    btnDeleteMovie.connect(SEL_COMMAND) do
      if validaInstancia then
        res = @prolog.haz("deleteMovie(#{@addMovie},#{@addYear})")
        @textArea.setText("movie(#{@addMovie},#{@addYear}) eliminada")
      end
    end

    ##
    # actualiza una pelicula al razonamiento
    ##
    btnUpdateMovie.connect(SEL_COMMAND) do
      if validaInstancia then
        @prolog.haz("updateMovie(#{@updateMovie},#{@updateMovieNew},#{@updateYear},#{@updateYearNew})")
        @textArea.setText("movie(#{@updateMovie},#{@updateYear}) actualizada a movie(#{@updateMovieNew},#{@updateYearNew})")
      end
    end

    ##
    # Guarda el estado de la base de datos
    # de reconocimiento
    ##
    btnRazona.connect(SEL_COMMAND) do
      if validaInstancia then
        res = @prolog.haz("customQuery(#{@customQuery})")
        texto = res[0].to_s.strip
        @textArea.setText(texto)
        
        # res = @prolog.hazCustom("call(#{@customQuery}),write(#{@customQuery}),nl,fail;true.")
        # puts "call(#{@customQuery}),write(#{@customQuery}),nl,fail;true."
        if res == nil
          print "no jala"
        end
      end
    end

  end

  def create
    super
    show(PLACEMENT_SCREEN)
  end

  ##
  # Valida que la instancia prolog este activa
  # ( que el archivo se haya abierto )
  # true: si esta activa
  # false: si no esta activa
  ##
  def validaInstancia
    if @prolog == nil then
      @textArea.setText("El archivo main debe abrirse\n")
      return false
    else
      return true
    end
  end

end

if __FILE__ == $0 then
  app = FXApp.new("AppSen")
  ven = GUI.new(app)
  app.create
  app.run
end