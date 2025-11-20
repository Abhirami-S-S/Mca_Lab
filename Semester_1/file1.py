"""write a program that retrives all lines from a file having words starts with 's' and ends with 'e'"""
def retrieve_lines(filename):
    with open(filename, 'r') as file:
        lines = file.readlines()
    
    result_lines = []
    for line in lines:
        words = line.split()
        for word in words:
            if word.lower().startswith('s') and word.lower().endswith('e'):
                result_lines.append(line.strip())
                break  # No need to check other words in the same line
    
    return result_lines
# Example usage:
filename = 'no.txt'  # Replace with your file name
lines_with_s_e = retrieve_lines(filename)
for line in lines_with_s_e:
    print(line)