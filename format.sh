#!/bin/bash

# Check if clang-format is installed
if command -v clang-format >/dev/null 2>&1; then
  echo "clang-format is already installed."
else
  echo "Installing clang-format..."
  sudo apt-get update
  sudo apt-get install -y clang-format
  if [ $? -ne 0 ]; then
    echo "Error: Failed to install clang-format."
    exit 1
  fi
fi

# Format C++ files
echo -e "\nFormatting C++ files..."
find . -type f -name "*.cpp" | while read -r file; do
  echo "Formatting $file..."
  clang-format -style=llvm -i "$file"
  if [ $? -ne 0 ]; then
    echo "Error: Failed to format $file."
    exit 1
  fi
done