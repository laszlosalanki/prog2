#include <boost/filesystem.hpp>
#include <iostream>

std::vector<std::string> getData() {

    std::vector<std::string> v = {};

    for (boost::filesystem::recursive_directory_iterator end, dir("./"); dir != end; ++dir) {
        if (dir->path().filename().string().find(".java") != std::string::npos && std::isupper(dir->path().filename().string()[0])) {
            v.push_back(dir->path().filename().string());
        }
    }

    return v;
}

int main(int argc, char *argv[])
{
    std::vector<std::string> v = getData();
    
    std::sort(v.begin(), v.end());

    for(int i = 0; i < v.size(); ++i) {
        std::cout << i << " - " << v.at(i) << std::endl;
    } 

    return 0;
}