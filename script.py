
class Automovil:
    def __init__(self, marca, modelo):
        self.marca = marca
        self.modelo = modelo

    def obtener_modelo(self):
        pass


class Auto_familiar(Automovil):
    def __init__(self, marca, modelo):
        super().__init__(marca, modelo)

    def obtener_modelo(self):
        return f"El auto familiar tiene un modelo: '{self.modelo}'"


class Auto_deportivo(Automovil):
    def __init__(self, marca, modelo):
        super().__init__(marca, modelo)

    def obtener_modelo(self):
        return f"El modelo '{self.modelo}' del auto deportivo es el más reciente"


auto_familiar = Auto_familiar("Ford", "Familiar 2023")
auto_deportivo = Auto_deportivo("Tesla", "Tesla motors sport")

# output: El auto familiar tiene un modelo: 'Familiar 2023'
print(auto_familiar.obtener_modelo())
# output: El modelo 'Tesla motors sport' del auto deportivo es el más reciente
print(auto_deportivo.obtener_modelo())
