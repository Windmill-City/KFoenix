package kfoenix

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import tornadofx.*

class JFXRadioButtonTestApp : App(Main::class, MyStyles::class) {

    class Main: View() {
        val selectedValue = SimpleStringProperty("")

        val user = UserModel(User("John Doe", "johnd", "oe", "jdoe@fake.io"))

        override val root = vbox {
            addClass(MyStyles.box)
            form {
                fieldset("User Information") {
                    field("Name") {
                        jfxtextfield(user.name)
                        jfxbutton(user.name)
                    }
                    field("Login") {
                        jfxtextfield(user.login)
                    }
                    field("Password") {
                        jfxtextfield(user.password)
                    }
                    field("Email") {
                        jfxtextfield(user.email)
                    }
                    field {
                        textProperty.bind(selectedValue)
                        togglegroup {
                            bind(selectedValue)
                            jfxradiobutton("Option One") {
                                isSelected = true
                            }
                            jfxtogglebutton("Option Two")
                            togglebutton("Option Three")
                            radiobutton("Option Four")
                        }
                    }
                }
            }
        }
    }

    class MyStyles: Stylesheet() {

        companion object {
            val bar by cssclass()
            val box by cssclass()
            val customerBtn by cssclass()
            val jfxButton by cssclass()
            val jfxRippler by cssclass()
            val jfxRipplerFill by cssproperty<Paint>("-jfx-rippler-fill")

            val defaultColor = Color.web("#4059a9")
        }

        init {
            /* Must place default styling first. Will overwrite more specific styling */
            jfxButton {
                backgroundColor += defaultColor
                textFill = Color.WHITE
            }

            bar {
                alignment = Pos.CENTER_RIGHT
                spacing = 10.px
            }

            box {
                prefHeight = 600.px
                prefWidth = 800.px
            }

            customerBtn {
                backgroundColor += Color.TRANSPARENT

                jfxRippler {
                    jfxRipplerFill.value = Color.GRAY
                }
            }
        }
    }
}