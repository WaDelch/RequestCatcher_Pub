function sortTable(n, tID) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById(tID);
  switching = true;
  dir = "asc";
  // Bubble Sort als Sortieralgorithmus
  while (switching) {
    switching = false;
    rows = table.rows;
    // Schleife startet mit Index 1, um den Tabellenkopf aus der Sortierung auszuschließen
    for (i = 1; i < (rows.length - 1); i++) {
      shouldSwitch = false;
      x = rows[i].getElementsByTagName("TD")[n];
      y = rows[i + 1].getElementsByTagName("TD")[n];
      // überprüft, ob ein Tausch der aktuellen beiden Elemente
      // entsprechend der Sortierreihenfolge notwendig ist
      if (dir == "asc") {
        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
          shouldSwitch = true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* vertauscht die Position der aktuellen beiden Elemente: */
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      switchcount ++;
    } else {
      /* Setzt die Sortierung auf absteigend und geht in den nächsten Schleifendurchlauf,
      falls kein Tausch vorgenommen wurde und die Sortierung aufsteigend ist */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}