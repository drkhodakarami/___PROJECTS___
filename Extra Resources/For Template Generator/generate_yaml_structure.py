import os
import yaml

def generate_folder_structure(path):
    folder_structure = {}
    for item in os.listdir(path):
        item_path = os.path.join(path, item)
        if os.path.isdir(item_path):
            folder_structure[item] = generate_folder_structure(item_path)
    return folder_structure

def main():
    # Get the current working directory
    root_path = os.getcwd()
    
    # Generate the folder structure
    folder_structure = generate_folder_structure(root_path)
    
    # Write the structure to a YAML file
    with open('folder_structure.yaml', 'w') as yaml_file:
        yaml.dump(folder_structure, yaml_file, default_flow_style=False)

if __name__ == "__main__":
    main()