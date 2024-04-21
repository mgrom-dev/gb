#include <iostream>
#include <sstream>
#include <vector>

int main() {
    std::string line;
    std::getline(std::cin, line);
    std::istringstream iss(line);
    std::vector<int> lineNumbers;
    int n;
    while (iss >> n) {
        lineNumbers.push_back(n);
    }

    int count = lineNumbers[0];
    int time = lineNumbers[1];

    std::getline(std::cin, line);
    std::istringstream iss2(line);
    std::vector<int> lineNumbers2;
    while (iss2 >> n) {
        lineNumbers2.push_back(n);
    }

    int min = lineNumbers2[0];
    int max = lineNumbers2[lineNumbers2.size() - 1];

    int employeeOut;
    std::cin >> employeeOut;

    if (count <= 0) return 0;

    if (employeeOut - min <= time || max - employeeOut <= time)
        std::cout << max - min << std::endl;
    else {
        int time1 = max - min + max - employeeOut;
        int time2 = max - min + employeeOut - min;
        std::cout << (time1 > time2 ? time2 : time1) << std::endl;
    }

    return 0;
}