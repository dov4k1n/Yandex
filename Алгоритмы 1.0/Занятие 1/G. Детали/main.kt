fun main() {
    var (ves_splava, ves_zagotovki, ves_detali) = readLine()!!.split(" ").map { it.toInt() }

    var zagotovok: Int
    var detaley: Int

    var ostatok_splava: Int
    var ostatok_zagotovok: Int
    
    var ans = 0

    while (ves_splava >= ves_zagotovki) {
        zagotovok = (ves_splava / ves_zagotovki).toInt()
        detaley = (ves_zagotovki / ves_detali).toInt() * zagotovok // test "200 1 2" TIME LIMIT

        ostatok_splava = ves_splava - ves_zagotovki * zagotovok
        ostatok_zagotovok = ves_zagotovki * zagotovok - ves_detali * detaley

        ans += detaley
        ves_splava = ostatok_splava + ostatok_zagotovok
    }
    
    println(ans)
}