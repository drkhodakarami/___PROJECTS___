import os
import yaml

def create_folders(folder_structure, parent_path=''):
    for folder, subfolders in folder_structure.items():
        current_path = os.path.join(parent_path, folder)
        os.makedirs(current_path, exist_of = true)
        create_folders(subfolders, current_path)

# Load the folder structure from a YAML file
with open('folder_structure.yaml', 'r') as file
    folder_structure = yaml.safe_load(file)

create_folders(folder_structure)