package uatx.mx.demorest.ws;

import org.springframework.web.bind.annotation.*;
import uatx.mx.demorest.model.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("personas")
public class PersonasController {
    List<Persona> personas = new ArrayList<>();

    @GetMapping("/saludar/{edad}")
    public String saludar(@RequestParam String nombre, @PathVariable Integer edad){
        return "Hola "+nombre+" tu edad es de "+edad;
    }




    @GetMapping("/consultar/todos")
    public List<Persona> consultarTodo(){
        return personas;
    }

    @PostMapping ("/registrar")
    public Persona registrarPersona(@RequestBody Persona persona){
        System.out.println("Los datos de la persona a registrar son:");
        System.out.println(persona.nombre);
        System.out.println(persona.edad);
        System.out.println(persona.sexo);

        Random random = new Random();
        persona.id=random.nextInt();

        personas.add(persona);

        return persona;

    }


}
