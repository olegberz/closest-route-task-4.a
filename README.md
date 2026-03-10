# Pašvaldību apmeklējuma maršruts

## Task
**SIA "Strādīgie"** uzņēmuma pārstāvim Jānim ir paredzētas tikšanās ar Latvijas pašvaldību amatpersonām. Pēc Rīgas valstpilsētas pašvaldības apmeklēšanas uzzinājis, ka 1 nedēļas vietā viņam ir atlikušas **tikai 24 stundas**, lai apmeklētu visas pārējās pašvaldības. Palīdzi Jānim atrast īsāko ceļu, kā apmeklēt pārējās pašvaldības un laikus atgriezties atpakaļ Rīgas Rātslaukumā.

---

## Implementation Details
Here I implemented **Nearest Neighbor** algorithm, because it's impossible to go straight throw all 42 points (it's possible, but operation time would be **$O(41!)$**, incredibly long). 



* **Distance:** Measured **by straight**, not road net.
* **Goal:** Find the shortest path to visit all municipalities and return to Rīgas Rātslaukums.

---

## Results
The program outputs:
1.  Approximately the **shortest route length**.
2.  **List of municipalities** in the sequence of the found route.
