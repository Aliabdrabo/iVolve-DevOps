# Automated Web Server Configuration Using Ansible Playbooks

## Objectives

- Automate web server installation and configuration using Ansible
- Install and enable **Nginx** on a managed node
- Deploy a custom `index.html` page
- Verify that the web server is running correctly
---
1. Playbook: `playbook1.yml`
    ```yaml
    ---
    - name: Automated Web Server Configuration
      hosts: hosts
      become: true
      tasks:
        - name: Install nginx
          apt:
            name: nginx
            state: present
            update_cache: yes

        - name: Ensure is running
          service:
            name: nginx
            state: started
            enabled: true

        - name: Customize web page
          copy:
            content: |
              <html>
              <head>
                  <title>Welcome to Ansible Web Server</title>
              </head>
              <body>
                  <h1> Hello from Ansible!</h1>
                  <p>This web server is configured automatically using Ansible.</p>
              </body>
              </html>
            dest: /var/www/html/index.nginx-debian.html




2. **Create an Inventory File** `inventory.ini`:
   ```ini
   [hosts]
   192.168.230.130
   

3. Run the Playbook:
   ```bash
   ansible-playbook -i inventory.ini playbook1.yml -k
   
   `-k` → ask for SSH password (if no key-based authentication).
   
4. **Verify Configuration**: 
   ```bash
   curl http://192.168.230.130
   
